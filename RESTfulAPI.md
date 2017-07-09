# 无需验证
##/api/login  POST
param

    username
    password

result

    timestamp
    code
    message
    data {SESSION}

code 为 0 表示登录成功
message 为提示信息
data 为 map, 登录成功时包含 SESSION

登录

##/api/checkLogin   GET
result

    timestamp
    code
    message
    data {isAuthenticated}

验证登录

## /api/game/gameVersion GET    未需求
游戏更新日志

## /api/game/gameVersion/{versionNumber} GET    未需求
得到目标版本游戏信息

## /api/game/gameVersion/latest GET    未需求
得到最新版本游戏信息

# 需要验证
## /api/user/myInfo GET
result

    AccountEntity
    
不包含 password 字段

获取用户自己的个人信息

## /api/game/user/pass  GET 未实现
param

    id
    
id 为关卡编号

用户通关某一关卡
