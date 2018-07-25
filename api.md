###只有SequenceIndo的ID是字符串类型
#图片
##向服务器端存储数据
```http request
POST /picture/upload
```
参数：
```
sequence:1
camera:1
frame:1
file:.jpg
```
返回
```json
{
"code":"0",
"msg":"成功",
"data":
{
      "sequence":"",
      "camera":"",
      "frame":"",
      "picturePath":""
}
}
```
##从服务器得到一张图片
```http request
GET /picture/download/sequence/camera/frame
```
参数：
无
返回
```json
{
"code":"0",
"msg":"成功",
"data":
{
    "camera":"1",
    "sequence":"1",
    "frame":"1",
    "file":""
}
}
```

#单张图片特征

##向服务器存储单张图片处理结果
```http request
POST /pictureResult/upload
```
参数

camera:1,
sequence:"1",
frame:1,
file:.mat,
boxes:""

返回
```json
{
"code":"0",
"msg":"成功",
"data":
{

}
}
```

##从服务器端请求处理结果
```http request
GET /pictureResult/download/sequence/camera/frame
```
参数：
无
返回
```json
{
"code":"0",
"msg":"成功",
"data":
    {
    "camera":"1",
    "sequence":"1",
    "frame":"",
    "features":".mat",
    "boxes":""
    }
}
```

#行人特征
##向服务器存储一个人的特征以及Id，注意如果人物出现多次，请分次上传
```http request
POST /personFeature/upload
```
参数
"file":.mat,
"sequence":"",
"personId":,

####我们将不同摄像头下同一个人统一统计，所以不区分摄像头
返回

```json
{
"code":"0",
"msg":"成功",
"data":
    {
    "sequence":"",
    "personId":"",
    "featurePath":""
    }
}
```


##从服务器读取一个人的feature
```http request
GET /personFeature/download/sequence/personId
```
参数
无
####我们将不同摄像头下同一个人统一统计，所以不区分摄像头
返回

```json
{
"code":"0",
"msg":"成功",
"data":
    {
    "sequence":"",
    "personId":"",
    "feature":""
    }
}
```

#图片特征




#整段视频的处理结果
##向服务器存储整段视频的处理结果（行人出现帧）
```http request
POST /personResult/upload
```
参数

"camera":,
"sequence":"",
"personId":,
"startFrame":,
"finishFrame":

返回

```json
{
"code":"0",
"msg":"成功",
"data":
    {
    "camera":"",
    "sequence":"",
    "personId":"",
    "startFrame":"",
    "finishFrame":""
    }
}
```
##从服务器得到某个行人的出现帧
```http request
GET /personResult/download/personId
```
参数
无
返回

```json
{
"code":"0",
"msg":"成功",
"data":[
    {
            "camera":"1",
            "sequence":"1",
            "personId":"1",
            "startFrame":"1",
            "finishFrame":"5"
    },
    {
            "camera":"1",
            "sequence":"1",
            "personId":"1",
            "startFrame":"10",
            "finishFrame":"20"
    }
    ]
    
}
```
