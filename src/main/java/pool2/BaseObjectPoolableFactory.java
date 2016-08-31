package pool2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class BaseObjectPoolableFactory extends BasePooledObjectFactory<BaseObject> {

	@Override
	public BaseObject create() throws Exception {
		return new BaseObject();
	}

	@Override
	public PooledObject<BaseObject> wrap(BaseObject obj) {
		return new DefaultPooledObject<BaseObject>(obj);
	}

}
