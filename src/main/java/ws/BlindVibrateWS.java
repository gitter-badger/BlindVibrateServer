/**
 * @license
 * Copyright 2016, Guilherme Ogliari Rodrigues
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ws;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/Service")
@Stateless
public class BlindVibrateWS {

	private static final Logger log = Logger.getLogger(BlindVibrateWS.class.getName() );
	
	@PersistenceContext(unitName="BlindVibrate")
	private EntityManager em;
	
	@OnMessage
	public void onMessage(Session session, String jsonMessage) {
		log.log(Level.INFO, "message: "+jsonMessage);
	}

	@OnOpen
	public void onOpen(Session session) {
		log.log(Level.INFO, "onOpen");
	}
	
	@OnClose
	public void onClose(Session session) {
		log.log(Level.INFO, "onClose");
	}
	
}
