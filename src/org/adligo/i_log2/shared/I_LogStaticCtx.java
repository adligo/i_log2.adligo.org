package org.adligo.i_log2.shared;


/**
 * This SHOULD NOT be used, but provides a legacy style LOG_FACTORY
 * so that code can still use that style of log initialization. <br/>
 * 
 * The preferred way is to either; <br/>
 * A) Pass around the I_LogCtx implementation of your choice,
 * through an old school imperative reference passing or via a
 * declarative style (i.e. Spring Context, MicroProfile, etc)<br/>
 * Or<br/>
 * B) Create you own annotation using the 
 * {@lin I_LogA} example to bind to some logging implementation.
 * Also note there will be a i_log2_4slf4j.adligo.org project 
 * that will bind it to slf4j for you, in case you would like 
 * to go that route.<br/>
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
public interface I_LogStaticCtx {
  /**
   * See Interface Notes above;
   */
  @Deprecated
  public static final I_LogCtx LOG_FACTORY = new I_LogCtx() {};
}
