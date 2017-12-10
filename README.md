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

### 3.接口

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
