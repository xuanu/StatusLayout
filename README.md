# StatusLayout
显示不同状态的布局。emptyLayout,errorLayout,noNetLayout,loadingLayout
> 基于原项目的修改[Android-View-Status](https://github.com/xuanu/Android-View-Status)  
  
原项目的实现方法是**动态生成一个View,添加到父布局中**，使用有一定的局限性。  
***  
> 新项目Github地址：[StatusLayout](https://github.com/xuanu/StatusLayout)  
> 新项目博客地址： [显示不同状态的布局](http://zeffect.cn/index.php/archives/13/)  
  
# 新项目实现原理  

1. 继承FrameLayout，状态布局和内容布局全部添加到这个布局下。  
2. 状态布局占满空间，需要显示某个布局时，隐藏其它布局，显示指定布局。  
3. 只支持一个子布局，超过>(n个状态布局+1个内容布局)会抛出异常
4. 不设置状态布局或者不调用showXXXView()方法，控件将不会加载，不占空间。如果前两个方法都没有调用，但是调用了setXXXClick(pClick);将会抛出异常，view没有初始化  

### 最后实现  
#### 使用方法  
```
project的build.gradle添加  
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}  
app的build.gradle添加  
dependencies {
	        compile 'com.github.xuanu:StatusLayout:1.0.0'
	}
```
1. 可自定义状态布局，默认的布局均为**可选项**(即不设置也可用)。  
```  
<cn.zeffect.views.statelayout.StateLayout
        android:id="@+id/statelayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:emptyLayout="@layout/layout_empty"
        app:errorLayout="@layout/layout_error"
        app:loadingLayout="@layout/layout_loading"
        app:noNetLayout="@layout/layout_nonet">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="这个是内容视图" />
    </cn.zeffect.views.statelayout.StateLayout>     
```  
2. 拥有方法  
```
showEmptyView();//显示空视图  
showNoNetView();//显示没有网络视图  
showLoadingView();//显示加载中布局  
showErrorView();//显示加载失败视图  
showContentView();//显示内容视图  
setNoNetClick(click);//设置没有网络时点击事件   
setLoadingClick(click);// 设置加载中的点击事件  
setErrorClick(click);//设置加载失败点击事件  
setEmptyClick(click);//设置没有数据时，点击事件  
```  
3. 加载中的布局原本是一个静态的图片，更换无限旋转的进度条[Android-LoadingView](https://github.com/xuanu/Android-LoadingView)  
4. 效果图：  
![image](http://ww4.sinaimg.cn/mw690/7a18e5c2gw1f8615kgf9ug206q085q49.gif)
