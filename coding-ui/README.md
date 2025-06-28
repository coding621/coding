1,安装依赖 npm install
2，启动
  mac npm run dev
  windows npm run serve
    如果报错 Error: error:0308010C:digital envelope routines::unsupported，说明node版本太高
    1,可以在PowerShell中执行 $env:NODE_OPTIONS="--openssl-legacy-provider 来解决
    2,实在不行就nodes降级到16吧，可以安装nvm来管理node版本，
      下载安装nvm  https://github.com/coreybutler/nvm-windows/releases
      nvm install 16 
      nvm use 16