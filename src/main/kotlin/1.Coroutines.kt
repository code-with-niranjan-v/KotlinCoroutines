import kotlinx.coroutines.*
//Coroutines
/*

    Coroutines are light wieghted thread,
    but they are not equal to thread.

    Coroutines run on background thread, and
    we can implement many numbers of coroutines
    in background thread.

 */

fun main() {

    runBlocking {
        println("Main thread started")

        val job: Job = GlobalScope.launch{
            println("Work Started... at ${Thread.currentThread().name}")
            doWork()
            println("Work Finished... at ${Thread.currentThread().name}")
        }



        job.join()
        println("Main thread Finished")

    }
}

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