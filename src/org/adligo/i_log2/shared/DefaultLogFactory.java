package org.adligo.i_log2.shared;

import java.util.concurrent.ConcurrentHashMap;
/**
 * This SHOULD NOT be used directly!  It is included as the
 * defulat method implementations of {@link I_LogCtx} and should
 * be used from that default implementation.
 * 
 * @author scott
 * This code lives (is maintained) here;
 * https://github.com/adligo/i_log2.adligo.org
 *         <pre>
 * <code>
 *         ---------------- Apache ICENSE-2.0 --------------------------
 *
 *         Copyright 2023 Adligo Inc
 * 
 *         Licensed under the Apache License, Version 2.0 (the "License"); you
 *         may not use this file except in compliance with the License. You may
 *         obtain a copy of the License at
 * 
 *         http://www.apache.org/licenses/LICENSE-2.0
 * 
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *         implied. See the License for the specific language governing
 *         permissions and limitations under the License.
 *         </code>
 *         </pre>
 */
public class DefaultLogFactory {
  protected static final DefaultLogFactory THIS = new DefaultLogFactory();
  private static final ConcurrentHashMap<String, DefaultLog> logs = new ConcurrentHashMap<>();
  
  private static DefaultLog getOrCreateLogInternal( 
      String logName, LogLevel level) {
    logs.putIfAbsent(logName, new DefaultLog(logName, 
        level, System.out, System.err));
    return logs.get(logName);
  }
  private final DefaultLog log;
  
  
  protected DefaultLogFactory() {
    log = getOrCreateLogInternal(DefaultLogFactory.class
        .getName(), LogLevel.Info);
  }
  
  public DefaultLog getOrCreateLog(String logName) {
    return getOrCreateLogInternal(logName, LogLevel.Info);
  }
  
  public DefaultLog getOrCreateLog(String logName, LogLevel level) {
    DefaultLog r = getOrCreateLogInternal(logName, level);
    if (r.getLevel() != level) {
      log.warn(new Exception("The following log is set to " +
          r.getLevel() + " but the level " + level + " was requested;\n" +
          logName));
    }
    return r;
  }
}
