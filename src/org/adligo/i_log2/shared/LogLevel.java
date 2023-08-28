package org.adligo.i_log2.shared;


/**
 * The enum for the various logging levels.<br/>
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
public enum LogLevel {
  Trace(1), Debug(2), Info(3), Warn(4), Error(5), Fatal(6), Off(7);
  private byte level;

  private LogLevel(int level) {
    this((byte) level);
  }
  
  private LogLevel(byte level) {
    this.level = level;
  }
  
  public byte getLevel() {
    return level;
  }
  
  /**
   * return true if this is greater than or equal to 
   * the level passed in.
   * I.E. if this is Off return false;
   * if this is Fatal and you pass Off return true;
   * if this is Fatal and you pass Fatal return true;
   * @param level
   * @return
   */
  public boolean isEnabled(LogLevel level) {
    if (this.level == Off.getLevel()) {
      return false;
    }
    if (this.level >= level.getLevel()) {
      return true;
    } else {
      return false;
    }
  }
}
