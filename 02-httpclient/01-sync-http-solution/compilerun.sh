rm -rf ./out && javac -d out --add-modules jdk.incubator.httpclient src/whatsnew/httpclient/SimpleHttpClientExample.java
java -cp out --add-modules jdk.incubator.httpclient whatsnew.httpclient.SimpleHttpClientExample
