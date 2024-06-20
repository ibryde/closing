package com.kardham.closing

import io.javalin.ApiBuilder.get
import io.javalin.ApiBuilder.post
import io.javalin.ApiBuilder.patch
import io.javalin.ApiBuilder.delete
import io.javalin.Javalin

import java.io.File

class InvalidUnionCast(message: String) : Exception(message)
class NotEnoughParams(message: String) : Exception(message)
class UnknownParams(message: String) : Exception(message)

class ArgType (
    val intVal : Int?,
    val strVal : String?
) {
    constructor(str: String) : this(null, str){ }
    constructor(int: Int) : this(int, null){ }

    inline fun <reified T> get() : T {
        return when (T::class) {
            String::class -> strVal as T ?: throw InvalidUnionCast("try to cast to string")
            Int::class -> intVal as T ?: throw InvalidUnionCast("try to cast to int")
            else -> throw InvalidUnionCast("unreachable")
        }
    }
}

fun parseArgs(args: Array<String>) : MutableMap<String, ArgType> {
    val parsedArgs = mutableMapOf<String, ArgType>()
    var index : Int = 0;
    while (index < args.size) {
        when(args[index]) {
            "--port" -> { 
                if (++index >= args.size) throw NotEnoughParams("--port INT")
                parsedArgs.put("port", ArgType(args[index].toInt()))
            }
            else -> throw UnknownParams(args[index])
        }
    }

    return parsedArgs;
}

fun main(args: Array<String>) {
	val arguments : MutableMap<String, ArgType> = parseArgs(args)

	val port : Int = arguments["port"]?.get() as? Int ?: 7123

	val app = Javalin.create().apply {
		port(port)
		exception(Exception::class.java) { e, _ -> e.printStackTrace() }
		error(404) { ctx -> ctx.json("not found") }
	}.start()

	app.routes {

		get("/users") { ctx ->
			ctx.status(501)
			ctx.json("Not Yet Implemented")
		}

		get("/users/:id") { ctx ->
			ctx.status(501)
			ctx.json("Not Yet Implemented")
		}

		get("/users/email/:email") { ctx ->
			ctx.status(501)
			ctx.json("Not Yet Implemented")
		}

		post("/users/create") { ctx ->
			ctx.status(501)
			ctx.json("Not Yet Implemented")
		}

		patch("/users/update/:id") { ctx ->
			ctx.status(501)
			ctx.json("Not Yet Implemented")
		}

		delete("/users/delete/:id") { ctx ->
			ctx.status(501)
			ctx.json("Not Yet Implemented")
		}
	}
}
