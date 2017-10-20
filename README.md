# Java 和暦 元号 設定ファイル(calendars.properties) ユーティリティ

---

## calendars_properties_builder
 設定ファイル(yaml)に書いた内容にしたがって、calendars.propertiesの断片をテキストファイルに出力するUtilです。  
 （※Oracle java updateできる環境では、不要なものです）
 
 * ruby 2.3 必要
 * java 必要(※native2asciiが要る)
 * Windows では、下記設定を記述したyamlを、batファイルにdropすると、設定内容にしたがってファイルが出力されます。

| 項目 | 型 | 内容 |
|:-----------|:------------|:------------|
|native2ascii_exe_path|String|native2ascii.exeのパス|
|since|String|開始時刻(ISO8601形式)UTCで指定する様子|
|name|String|元号名称|
|abbr|String|略称|
|erb_template|String(ERB)|出力テンプレート|
|file_path|String|出力ファイル名|
 
---
 
# NextJapaneseEra
　上記ユーティリティで作成した下記設定内容を、JRE_HOME/lib/calendars.propertiesに設定後に、  
新元号が正しく動作するかどうかをチェックするjavaプロジェクト

<pre>
#
# Japanese imperial calendar
#
#   Meiji  since 1868-01-01 00:00:00 local time (Gregorian)
#   Taisho since 1912-07-30 00:00:00 local time (Gregorian)
#   Showa  since 1926-12-25 00:00:00 local time (Gregorian)
#   Heisei since 1989-01-08 00:00:00 local time (Gregorian)
calendar.japanese.type: LocalGregorianCalendar
calendar.japanese.eras: \
	name=Meiji,abbr=M,since=-3218832000000;  \
	name=Taisho,abbr=T,since=-1812153600000; \
	name=Showa,abbr=S,since=-1357603200000;  \
	name=Heisei,abbr=H,since=600220800000;   \
	name=\u56db\u6708\u4e00\u65e5UTC\u5207\u66ff\u5143\u53f7,abbr=N,since=1554076800000

</pre>