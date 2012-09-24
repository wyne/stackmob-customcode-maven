## StackMob Custom Code Example Project (Maven-based)

This example project is a simple Hello World.  This adds a server-side method called "hello_world" which can be called from your client iOS, Android, Java Client or JS SDKs:

    http://api.stackmob.com/hello_world
    
Custom code allows you to even define the returned JSON.  In this case, our simple Hello World example will return:

    { "msg": "Hello, world!" }
    
You can call your server-side custom code from your SDK.  The request will be sent from the client, StackMob will route the call to the appropriate code and execute the code you've written, then StackMob will return the JSON you've defined.

<span class="tab callcc" title="iOS SDK"/>
**iOS SDK**

```objc
[[StackMob stackmob] get:@"hello_world" withCallback:^(BOOL success, id result) {
    if (success) {
        // result is the JSON as an NSDictionary of "msg" vs. "Hello, world!"
    } else {
    }
}];

```
<span class="tab"/>

<span class="tab callcc" title="Android SDK"/>
**Android SDK**

```java
StackMobCommon.getStackMobInstance().get("hello_world", new StackMobCallback() {
    @Override public void success(String responseBody) {
        //responseBody is "{ \"msg\": \"Hello, world!\" }"
    }
    @Override public void failure(StackMobException e) {
    }
});
```
<span class="tab"/>

<span class="tab callcc" title="JS SDK"/>
**JS SDK**

```javascript
<script type="text/javascript">
  StackMob.customcode('hello_world', {}, {
     success: function(jsonResult) {
       //jsonResult is the JSON object: { "msg": "Hello, world!" }
     },
     
     error: function(failure) {
       //doh!
     }
  });
</script>
```
<span class="tab"/>

### Java (Maven)

Building:

1. mvn clean package
2. JAR is located in target

### Deploying

To deploy your Custom Code, first link your github repo with StackMob by authorizing StackMob <a href="https://www.stackmob.com/platform/api/customcode/upload/github">here</a>. Then just 'push' to your 'master' branch and your code will be built and deployed seamlessly to the StackMob platform. Your code is only automatically deployed in the Development environment. You retain control when you want to manually deploy to Production. You can also see a <a href="https://www.stackmob.com/platform/api/customcode/history">history</a> of your deployments.
