# The new ProcessHandle API

With the following exercises, it pays to read the `ProcessHandle` JavaDoc closely.


## 01. Current process id

Open `src/whatsnew/process/ProcessId.java` and look at the code.
There is no exercise here, just an illustration of what you previously needed to do to get the current pid.
The `ProcessHandle::current` method gives you back the `ProcessHandle` for the running Java process.

## 02. Listing all processes

Open `src/whatsnew/langandlib/optional/ListProcesses.java`.
Use the `ProcessHandle` API to list all processes currently running on your machine.

There's a static method on `ProcessHandle` that can get you started.
Try to order the processes by start time (you can get this info from the `ProcessHandle.Info` associated with a `ProcessHandle`).
You can use the `printInfo` method to print a nice line for each `ProcessHandle.Info`.

## Bonus step: kill another process

Instead of listing all processes, try to find a specific process by (partial) name.
Then, use `destroy` to kill it.
There's also `destroyForcibly`, if you really want...
You can use `KillOtherProcess.java` to get started.
But, before killing the process, attach a callback on the obtained `ProcessHandle` through its `onExit` method.
It returns a `CompletableFuture` (that we saw before in the HttpClient exercises) that you can attach callbacks on.

TIP: remember that you should `join` a `CompletableFuture` if you want the program to wait for the completion (and execution of the callback).

TIP: some processes cannot be destroyed, therefore the `destroy` method returns a boolean whether it succeeded or not

PRO-TIP: try not to kill any vital operating system processes in this exercise :-)
