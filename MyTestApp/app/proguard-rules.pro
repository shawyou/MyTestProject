# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/linshaoyou/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#基线包使用，生成mapping.txt
-printmapping mapping.txt
#生成的mapping.txt在app/buidl/outputs/mapping/release路径下，移动到/app路径下
#修复后的项目使用，保证混淆结果一致
#-applymapping mapping.txt
#hotfix
-keep class com.taobao.sophix.**{*;}
-keep class com.ta.utdid2.device.**{*;}
#防止inline
-dontoptimize


-optimizationpasses 5

-dontusemixedcaseclassnames

-dontskipnonpubliclibraryclasses

-dontpreverify

-verbose

-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keep public class * extends android.app.Activity

-keep public class * extends android.app.Application

-keep public class * extends android.app.Service

-keep public class * extends android.content.BroadcastReceiver

-keep public class * extends android.content.ContentProvider

-keepclasseswithmembernames class * {

    native <methods>;

}

-keepclasseswithmembernames class * {

    public <init>(android.content.Context, android.util.AttributeSet);

}

-keepclasseswithmembernames class * {

    public <init>(android.content.Context, android.util.AttributeSet, int);

}

-keepclassmembers enum * {

    public static **[] values();

    public static ** valueOf(java.lang.String);

}

-keep class * implements android.os.Parcelable {

  public static final android.os.Parcelable$Creator *;

}


# 将"Unknown Source"重新定义为“SourceFile”字符串
-renamesourcefileattribute SourceFile

# 保留源文件名为“SourceFile”字符串，而非原始的类名，并保留行号
-keepattributes SourceFile,LineNumberTable