# HouseKeeper

### 1.介绍
创新实践2项目——管家婆

### 2.技术栈

##### **语言**
- java

##### **框架**
- struts2 2.5.12
- spring 4.3.8
- hibernate 5.2.11

##### 插件
- FastJson
- C3P0 数据库连接池

##### 其他
- SHA256 加密

### 3.API

#### item部分
- 增加：

```
url:zjh.hduzjh.cn/HouseKeeper/item-add
接口参数：
{
    which//String，i为增加父类，否则增加子类
    itemName//String，父类名称，若增加子类则为空
    type//int，父类类型，0为收入，1为支出，如增加子类则为空
    subItemName//String，子类名称，若增加父类则为空
    itemId//int，子类属于的父类的id，若父类则为空
}
返回结果：
{
    result//成功为SUCCESS，失败为FAILED，参数错误为ERROR
}
```
- 删除

```
url:zjh.hduzjh.cn/HouseKeeper/item-delete
接口参数:
{
    which//String，i为删除父类，否则删除子类
    id//int，父类或子类的id
}
返回结果：
{
    result//成功为SUCCESS，失败为FAILED，参数错误为ERROR
}
```

- 修改

```
url:zjh.hduzjh.cn/HouseKeeper/item-update
接口参数：
{
    which//String，i为修改父类，否则修改子类
    id//int，父类或子类的id
    itemName//String，父类修改的名称，若修改子类则为空
    subItemName//String，子类修改的名称，若修改父类则为空
}
返回结果：
{
    result//成功为SUCCESS，失败为FAILED，参数错误为ERROR
}
```
- 查询

```
url:zjh.hduzjh.cn/HouseKeeper/item-get
接口参数：
{
    which//String，i为查询父类，否则查询子类
    type//int，0为查询收入类，1为查询支出类，若查询子类则为空
    itemId//int，所属的父类id，若查询父类则为空
}
返回结果：
//查询父类：
[
    {
        itemId//父类id
        itemName//父类名字
        type//父类属性
    }
]
//查询子类：
[
    {
        "id": {
            itemId//所属父类id
            subitemId//子类id
            subitemName//子类名字
        }
    }
]
```
#### account部分
- 查询
```
url:zjh.hduzjh.cn/HouseKeeper/account-query
接口参数：无
返回结果：
{
    accountId//账户id
    accountName//账户名字
}
```
#### cash部分
- 增加

```
url:zjh.hduzjh.cn/HouseKeeper/cash-save
接口参数：
{
    which//String，i为保存收入，否则保存支出
    time//时间，格式yyyy-MM-dd HH：mm
    site//String，位置
    people//String，有关人员
    money//double，金额
    remark//String，备注
    memberId//int，保存的成员id
    itemId//int，父类的id
    subItemId//int，子类的id
    accountId//int，账户的id
}
返回结果：
{
    result//成功为SUCCESS，失败为FAILED，参数错误为ERROR
}
```

- 查询某一成员收支记录

```
url:zjh.hduzjh.cn/HouseKeeper/cash-memberQuery
接口参数：
{
    which//String，i为查询收入，否则查询支出
    memberId//int，查询的成员id
}
返回结果：
//收入查询
[
    {
        "id": {
            accountId//账户id
            accountName//账户名称
            cashinId//收入id
            itemId//父类id
            itemName//父类名称
            memberId//成员id
            money//金额
            people//有关人员
            remark//备注
            site//地点
            subitemId//子类id
            subitemName//子类名称
            time//时间，时间戳
        }
    }
]
//支出查询
[
    {
        "id": {
            accountId//账户id
            accountName//账户名称
            cashoutId//支出id
            itemId//父类id
            itemName//父类名称
            memberId//成员id
            money//金额
            people//有关人员
            remark//备注
            site//地点
            subitemId//子类id
            subitemName//子类名称
            time//时间，时间戳
        }
    }
]
```
