package zkTest;

import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

public class Client {

	String url = "/server";
	ZooKeeper zkCli;

	@Before
	public void getZk() {
		ZKInit zkInit = new ZKInit();
		zkCli = zkInit.zkCli;
	}

	@Test
	public void getNode() throws KeeperException, InterruptedException {

		Watcher watcher = new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				List<String> children = null;
				try {
					children = zkCli.getChildren(url, true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(children);

			}
		};

		zkCli.register(watcher);

		Thread.sleep(Long.MAX_VALUE);

	}

}
