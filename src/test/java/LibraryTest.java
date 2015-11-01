import com.luxvelocitas.datautils.DataBundle;
import com.luxvelocitas.tinybt.exec.IExecutor;
import com.luxvelocitas.tinybt.exec.SimpleExecutor;
import com.luxvelocitas.tinybt.node.*;
import com.luxvelocitas.tinybt.node.composite.Sequence;
import com.luxvelocitas.tinybt.node.decorator.Invert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertTrue;

/*
 */
public class LibraryTest {
    @Test public void testTinyBtExperimental() {
        Logger logger = LoggerFactory.getLogger(LibraryTest.class);

        logger.info("START");
        INode<DataBundle> root = new Root<DataBundle>(
            new Invert<>(
                new Sequence<DataBundle>(
                    new Wait<DataBundle>(1000),
                    new Task<DataBundle>() {
                        @Override
                        public NodeState tick(Logger logger, DataBundle context) {
                            logger.info("TASK!");
                            return success();
                        }
                    }
                )
            )
        );

        DataBundle context = new DataBundle();

        IExecutor<DataBundle> executor = new SimpleExecutor(logger);
        executor.execute(root, context);
        logger.info("END");
        assertTrue("testTinyBtExperimental", true);
    }
}
