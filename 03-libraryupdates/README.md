# API updates

Besides the HttpClient API, there are many other new APIs and updates to existing APIs in the Java releases since Java 8. You'll get to exlore a few of them in these exercises. In order to get a full overview of what changed API-wise between Java version, I recommend looking at this overview: https://github.com/marchof/java-almanac/ This is a great way to explore API diffs between arbitrary versions of Java.

Of course knowing is only half the battle, so the following exercises will give you some hands-on experience with a few new and updated APIs.

## 01. Optional & Stream updates
Introduced in Java 8, `Optional` and `Stream` have been an instant success in most Java codebases.
In Java 9 and later, these APIs have been enhanced with new methods, for example new Collectors on `Stream` and new combinator methods on `Optional`.
These exercises allow you to explore some of these additions.

## 02. ProcessHandle API
`ProcessHandle` is a new addition to the existing `Process` API in Java.
Through `ProcessHandle` you can now also monitor and manage arbitrary processes running on the machine, not just process spawned from the current Java process.
In this exercise you'll see how you can use `ProcessHandle` to get a current overview of processes, and how kill an individual process.
