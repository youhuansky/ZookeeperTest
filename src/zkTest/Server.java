package zkTest;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

public class Server {

	String url="/server/server1";
	String data="test";
	ZooKeeper zkCli;
	int version=0;
	@Before
	public void getZk() {
		 ZKInit zkInit = new ZKInit();
		 zkCli = zkInit.zkCli;
	}
	
	
	@Test
	public void online() throws KeeperException, InterruptedException {
		
		String create = zkCli.create(url, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		
	}
	
	@Test
	public void offline() throws KeeperException, InterruptedException {
		
		zkCli.delete(url, version);
		version++;
		
	}
	
}
