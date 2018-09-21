rm -rf ./out && javac -d out --add-modules jdk.incubator.httpclient src/whatsnew/httpclient/AsyncHttpBuilderExample.java
java -cp out --add-modules jdk.incubator.httpclient whatsnew.httpclient.AsyncHttpBuilderExample
