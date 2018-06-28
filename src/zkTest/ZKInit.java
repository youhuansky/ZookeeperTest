package zkTest;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZKInit {
	String url="/server";
	String urlStr = "hadoop102:2181,hadoop103:2181,hadoop104:2181";
	ZooKeeper zkCli;

	{
		try {
			zkCli = new ZooKeeper(urlStr, 2000,null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

//new Watcher() {
//
//	@Override
//	public void process(WatchedEvent event) {
//		List<String> children=null;
//		try {
//			children = zkCli.getChildren(url, true);
//		} catch (KeeperException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		for (String string : children) {
//			System.out.println(string);
//		}
//		
//	}
//}
