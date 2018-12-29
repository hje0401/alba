package stockmgmt.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import stockmgmt.common.model.ResultVO;

public class UtilController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void printResultLog(ResultVO resultVo) {
		if(log.isDebugEnabled()) {
			log.debug("\n##########################################################################################################################################"); 
			log.debug("\n# RESULT : "); 
			log.debug(resultVo.toString()); 
			log.debug("\n##########################################################################################################################################"); 
		}
	}
}
