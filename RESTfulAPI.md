# 验证说明
任何需要验证的 API 在未验证情况下访问, 都会返回 401 错误.

正常情况会返回 200, 但是具体的 API 可能会根据情况返回其他 HttpStatus, 若未特殊说明则表明该 API 一定返回 200 (不包括 API 编写错误导致 500).

在 API 错误情况下导致 500, 会返回 Spring 默认错误提示, 下面是一个示例 (HttpStatus 为 500)

    {"timestamp":1499665184697,"status":500,"error":"Internal Server Error","exception":"java.lang.NullPointerException","message":"No message available","path":"/api/checkLogin"}

若请求参数缺失或不合法(为 null 或类型不匹配), 会返回类似如下结果(HttpStatus 为 400)

    {"timestamp":1499922767486,"code":-400,"message":"IllegalArgument"}

凭证可用 cookie 方式, 或使用 HttpBasic 方式.

cookie 方式需要首先通过登录 API 得到 cookie 名称和值, 每个访问都需要带有此 cookie.

HttpBasic 方式:

    http://username:password@localhost:8080/someAuthenticationRequestedAPI

服务端存储的 Session 有效期七天, 有效的 API 访问会刷新有效期. 请在客户端开启前验证一次登录.

# 无需验证
##/api/login  POST
param

    username
    password

result(success)

    timestamp
    code
    message
    data {SESSION}

example

    {"timestamp":1499663721462,"code":0,"message":"","data":{"SESSION":"326d66c9-89b4-4fe0-b37a-1d36a5c27456"}}
    
code 为 0 表示登录成功

message 为提示信息

data 为 map, 登录成功时包含 SESSION, 即 cookie 的值

error

    1   Bad credentials

feature

登录

##/api/checkLogin   GET
result

    timestamp
    code
    message
    data {isAuthenticated}

example 

    {"timestamp":1499664195631,"code":0,"message":"","data":{"isAuthenticated":true}}
    
feature

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
    
example

    {"id":1,"username":"admin","nick":"czp","avatar":"/image/avatar/user/rjxXGgS5L9448DAzQToW.jpg","gameFlag":"[1,2]"}

feature

获取用户自己的个人信息

## /api/user/game/levelClear  POST
param

    id

id 为关卡编号

result

    timestamp
    code
    message
    data {couponInstance}

当通关有优惠券时, couponInstance 为优惠券实例, 否则无此字段.

example

    {"timestamp":1500007260854,"code":0,"message":"","data":{"couponInstance":{"id":7,"coupon":{"id":2,"name":"通关奖励代金券","value":10.0},"account":{"id":1,"username":"admin","nick":"czp","avatar":"/image/avatar/user/rjxXGgS5L9448DAzQToW.jpg","gameFlag":"[2]"},"balance":10.0}}}

error

    1   No such level
    2   Already cleared this level

feature

用户通关某一关卡

同时获得通关该关卡得到的奖励
