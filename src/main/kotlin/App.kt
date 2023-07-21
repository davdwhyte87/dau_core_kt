import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import io.github.cdimascio.dotenv.Dotenv
import src.blockchain.Node
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.InetSocketAddress
import java.net.Socket
import java.util.*

class HelloHandler:HttpHandler{
    override fun handle(exchange: HttpExchange?) {
        val os = exchange?.responseBody
        if (os != null) {
            os.write("Hello I am totally fine".toByteArray())
        }
        if (os != null) {
            os.close()
        }
    }
}
class MyHandler : HttpHandler {
    override fun handle(t: HttpExchange) {
        val reqBody = t.requestBody.reader().readText()
//        println(t.requestBody.reader().readText())
        val client = Socket("localhost", 100)
        val req = "{\"action\":\"CREATE_WALLET\",\"createWallet\":{\"walletName\":\"Jumoni\",\"password\":\"12345\"}}"
        println(reqBody)
//        client.outputStream.write(req.toByteArray())
        client.outputStream.write(reqBody.toByteArray())
        val input = client.getInputStream().read()
        val inp = BufferedReader(InputStreamReader(client.getInputStream()))
//        println(inp.readLine())
        val response = inp.readLine()


        t.sendResponseHeaders(200, response.length.toLong())
        val os = t.responseBody
        os.write(response.toByteArray())
        os.close()
        client.close()
    }
}
internal object App {
    @JvmStatic
    fun main(args: Array<String>) {

        var dotenv: Dotenv = Dotenv.load()
        val server = HttpServer.create(InetSocketAddress(dotenv.get("NODE_PORT", "3000").toInt()), 0)
        server.createContext("/test", MyHandler())
        server.createContext("/hello", HelloHandler())
        server.executor = null // creates a default executor
        server.start()

//        val node: Node = Node()
//        node.StartServer()

//  node.GetAllNodes();

//    Consencus consencus = new Consencus();
//    ArrayList<String> datalist= new ArrayList<>();
//
//    datalist.add("no");
//    datalist.add("yes");
//    datalist.add("no");
//    datalist.add("yes");
//    datalist.add("no");
//    datalist.add("yes");
//    datalist.add("yes");
//    datalist.add("yes");
//    datalist.add("yes");
//    Consencus.Vote resultVote = consencus.Vote(datalist.toArray());
//    System.out.println("vote count : "+ resultVote.Count);
//    System.out.println("vote data : "+ resultVote.object);
        val input = Scanner(System.`in`)
        print("Press Enter to quit...")
        input.nextLine()
    }
}