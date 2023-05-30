import kotlinx.coroutines.*
import kotlin.concurrent.thread

//Coroutines
/*

    Coroutines are light weighted thread,
    but they are not equal to thread.

    Coroutines run on background thread, and
    we can implement many numbers of coroutines
    in background thread.

    Unlike for threads, the main thread won't wait for the coroutines to
    complete their work.

 */

fun main() {



    runBlocking {
        println("Main thread started")

        val job: Job = GlobalScope.launch{
            println("Work Started... at ${Thread.currentThread().name}")
            doWork()
            println("Work Finished... at ${Thread.currentThread().name}")
        }



        job.join()// waits for the coroutines to complete its work and runs the main thread.
        println("Main thread Finished")

    }
}

//Suspended Function

/*

    A suspended function is used to run inside only on coroutines,
    they can be called only within a suspend function or a coroutine.

 */
suspend fun doWork(){


    for (i in 1 ..5){

        for (j in 5 downTo i){
            print(" ")
        }
        for (k in 1..i){

            print("* ")

        }
        println()
        delay(1000)

    }

}