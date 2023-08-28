package org.adligo.i_log2.shared;


/**
 * This is the basic log factory, that can be mixed into 
 * your context object and passed around or delivered via 
 * a custom annotation.
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
public interface I_LogCtx {
  /**
   * 
   * @param clazz the name of the logger
   * @return
   */
  @SuppressWarnings("rawtypes")
  default I_Log getLog(Class clazz) {
    return DefaultLogFactory.THIS.getOrCreateLog(clazz.getName());
  }
  
  /**
   * 
   * @param clazz the name of the logger
   * @param level the log level, which MAY be overridden by
   *   log configuration.  
   * @return
   */
  @SuppressWarnings("rawtypes")
  default I_Log getLog(Class clazz, LogLevel level) {
    return DefaultLogFactory.THIS.getOrCreateLog(clazz.getName(), level);
  }
  /**
   * 
   * @param name the name of the logger
   * @return
   */
  default I_Log getLog(String name) {
    return DefaultLogFactory.THIS.getOrCreateLog(name);
  }
  
  /**
   * 
   * @param name the name of the logger
   * @param level the log level, which MAY be overridden by
   *   log configuration.  
   * @return
   */
  default I_Log getLog(String name, LogLevel level) {
    return DefaultLogFactory.THIS.getOrCreateLog(name, level);
  }
}
