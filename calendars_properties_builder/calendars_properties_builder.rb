module CalendarsPropertiesBuilder
  module_function
  def process(setting)
    # 開始ミリ秒
    require 'time'
    since_time = Time.iso8601(setting['since'])
    since = (since_time.to_i * 1000) + (since_time.usec / 1000) # millisec
    
    # 略称
    abbr = setting['abbr']
    
    # 元号名称
    name_orig = setting['name']
    name = (IO.popen("\"#{setting['native2ascii_exe_path']}\" -encoding UTF8", 'r+') do |io|
      io.puts(name_orig)
      io.close_write
      io.gets
    end).chomp('')

    require 'erb'
    content = ERB.new(setting['erb_template']).result(binding)
    
    if setting['file_path']
      File.open(setting['file_path'], 'w'){|f| f.write(content)}
      return
    end

    puts content
  end
end

if __FILE__ == $0
  exit false if ARGV.empty?

  ARGV.each do |def_file|
    next unless FileTest::exist?(def_file)

    require 'yaml'
    setting = YAML.load_file(def_file)
    
    CalendarsPropertiesBuilder::process(setting)
  end
end
