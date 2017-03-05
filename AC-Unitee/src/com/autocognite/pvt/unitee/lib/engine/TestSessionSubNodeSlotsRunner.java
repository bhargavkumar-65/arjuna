/*******************************************************************************
 * Copyright 2015-16 AutoCognite Testing Research Pvt Ltd
 * 
 * Website: www.AutoCognite.com
 * Email: support [at] autocognite.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.autocognite.pvt.unitee.lib.engine;

import org.apache.log4j.Logger;

import com.autocognite.batteries.config.RunConfig;
import com.autocognite.batteries.util.ThreadBatteries;
import com.autocognite.pvt.ArjunaInternal;
import com.autocognite.pvt.unitee.core.lib.exception.SubTestsFinishedException;
import com.autocognite.pvt.unitee.runner.lib.slots.TestSlotExecutor;
import com.autocognite.pvt.unitee.testobject.lib.loader.group.Group;
import com.autocognite.pvt.unitee.testobject.lib.loader.session.SessionNode;
import com.autocognite.pvt.unitee.testobject.lib.loader.session.SessionSubNode;

public class TestSessionSubNodeSlotsRunner implements Runnable {
	private static Logger logger = RunConfig.getCentralLogger();
	SessionSubNode subNode = null;
	
	public TestSessionSubNodeSlotsRunner(SessionSubNode subNode){
		this.subNode = subNode;
	}
	
	public void run(){
		TestSlotExecutor slotExecutor = null;
		logger.debug(String.format("Session Sub Node %s started.", this.subNode.getName()));
		while (true){
			try{
				slotExecutor = subNode.next();
			} catch (SubTestsFinishedException e){
				logger.debug(String.format("Session Sub Node %s finished.", this.subNode.getName()));
				break;
			} catch (Throwable e){
				logger.debug("Unexpected issue in Session runner.");
				e.printStackTrace();
			}
			if (ArjunaInternal.displayLoadingInfo){
				logger.debug("Run Slot# " + slotExecutor.getSlotNumber());
			}
			
			slotExecutor.run();
		}	
	}
	
}

