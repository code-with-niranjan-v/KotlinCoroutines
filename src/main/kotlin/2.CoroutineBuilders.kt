import kotlinx.coroutines.*

//Coroutine Builders
/*
    They are used to launch coroutines in thread.
    There are two coroutine builders,
        * Launch
        * Async
 */
fun main() {
    //runBlocking is running on the main thread
    runBlocking {
        //It inherits the runBlocking scope
        //So, it runs on the main thread
        //Launch returns a Job type object
        val job: Job = launch {

            doJob()

        }
        job.join()

        //Same as launch, it also runs on the main thread.
        //Async can return both job and deferred type.
        val job2:Deferred<String> = async {

            doJob()
            "Finished Work!"
        }

        val result= job2.await()

        println(result)

        //Async may seem similar to launch, but it can return a value when it finishes its task.



    }

}

fun doJob(){

    for(i in 1..10){
        println("Doing Work... at ${Thread.currentThread().name}")
    }

}