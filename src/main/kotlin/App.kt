import src.blockchain.Node
import java.util.*

internal object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val node: Node = Node()
        node.StartServer()

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