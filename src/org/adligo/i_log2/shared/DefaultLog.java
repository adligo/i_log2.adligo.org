package org.adligo.i_log2.shared;

import java.io.PrintStream;
import java.util.Objects;

/**
 * This is the default simplest logger possible.
 * 
 * @author scott This code lives (is maintained) here;
 *         https://github.com/adligo/i_log2.adligo.org
 * 
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
public class DefaultLog implements I_Log {
  public static final String AN_ERROR_STREAM_IS_REQUIRED = "An error stream is required!";
  public static final String AN_OUTPUT_STREAM_IS_REQUIRED = "An output stream is required!";
  public static final String A_LEVEL_IS_REQUIRED = "A level is required!";
  public static final String A_NAME_IS_REQUIRED = "A name is required!";
  /**
   * The name of the class for this log, or the string name.
   */
  private final String name;
  /** The current log level */
  private final LogLevel level;
  
  private final PrintStream out;
  private final PrintStream err;
  
  public DefaultLog(String name, LogLevel level, PrintStream out, PrintStream err) {
    this.name = Objects.requireNonNull(name, A_NAME_IS_REQUIRED);
    this.level = Objects.requireNonNull(level, A_LEVEL_IS_REQUIRED);
    this.out = Objects.requireNonNull(out, AN_OUTPUT_STREAM_IS_REQUIRED);
    this.err = Objects.requireNonNull(err, AN_ERROR_STREAM_IS_REQUIRED);
  }
  
  /**
   * @See {@link I_Log#isEnabled()}
   */
  public boolean isEnabled() {
    return level.isEnabled(LogLevel.Off);
  }

  /**
   * @See {@link I_Log#isDebugEnabled()}
   */
  public boolean isDebugEnabled() {
    return level.isEnabled(LogLevel.Debug);
  }

  /**
   * @See {@link I_Log#isErrorEnabled()}
   */
  public boolean isErrorEnabled() {
    return level.isEnabled(LogLevel.Error);
  }

  /**
   * @See {@link I_Log#isFatalEnabled()}
   */
  public boolean isFatalEnabled() {
    return level.isEnabled(LogLevel.Fatal);
  }

  /**
   * @See {@link I_Log#isInfoEnabled()}
   */
  public boolean isInfoEnabled() {
    return level.isEnabled(LogLevel.Info);
  }

  /**
   * @See {@link I_Log#isTraceEnabled()}
   */
  public boolean isTraceEnabled() {
    return level.isEnabled(LogLevel.Trace);
  }

  /**
   * @See {@link I_Log#isWarnEnabled()}
   */
  public boolean isWarnEnabled() {
    return level.isEnabled(LogLevel.Warn);
  }

  /**
   * @See {@link I_Log#trace(Object)}
   */
  public void trace(Object message) {
    out.print(toMessage(message));
  }

  /**
   * @See {@link I_Log#trace(Object,Throwable)}
   */
  public void trace(Object message, Throwable t) {
    out.print(toMessage(message,t));
  }
  
  /**
   * @See {@link I_Log#trace(Throwable)}
   */
  public void trace(Throwable t) {
    out.print(toMessage(t));
  }

  /**
   * @See {@link I_Log#debug(Object)}
   */
  public void debug(Object message) {
    out.print(toMessage(message));
  }

  /**
   * @See {@link I_Log#debug(Object,Throwable)}
   */
  public void debug(Object message, Throwable t) {
    out.print(toMessage(message,t));
  }

  /**
   * @See {@link I_Log#debug(Throwable)}
   */
  public void debug(Throwable t) {
    out.print(toMessage(t));
  }

  /**
   * @See {@link I_Log#info(Object)}
   */
  public void info(Object message) {
    out.print(toMessage(message));
  }

  /**
   * @See {@link I_Log#info(Object,Throwable)}
   */
  public void info(Object message, Throwable t) {
    out.print(toMessage(message,t));
  }

  /**
   * @See {@link I_Log#info(Throwable)}
   */
  public void info(Throwable t) {
    out.print(toMessage(t));
  }

  /**
   * @See {@link I_Log#warn(Object)}
   */
  public void warn(Object message) {
    out.print(toMessage(message));
  }

  /**
   * @See {@link I_Log#warn(Object,Throwable)}
   */
  public void warn(Object message, Throwable t) {
    out.print(toMessage(message, t));
  }

  /**
   * @See {@link I_Log#warn(Throwable)}
   */
  public void warn(Throwable t) {
    out.print(toMessage(t));
  }

  /**
   * @See {@link I_Log#error(Object)}
   */
  public void error(Object message) {
    err.print(toMessage(message));
  }

  /**
   * @See {@link I_Log#error(Object,Throwable)}
   */
  public void error(Object message, Throwable t) {
    err.print(toMessage(message,t));
  }

  /**
   * @See {@link I_Log#error(Throwable)}
   */
  public void error(Throwable t) {
    err.print(toMessage(t));
  }

  /**
   * @See {@link I_Log#fatal(Object)}
   */
  public void fatal(Object message) {
    err.print(toMessage(message));
  }

  /**
   * @See {@link I_Log#fatal(Object,Throwable)}
   */
  public void fatal(Object message, Throwable t) {
    err.print(toMessage(message, t));
  }

  /**
   * @See {@link I_Log#fatal(Throwable)}
   */
  public void fatal(Throwable t) {
    err.print(toMessage(t));
  }

  /**
   * @See {@link I_Log#getLogName()}
   */
  public String getLogName() {
    return name;
  }

  @Override
  public LogLevel getLevel() {
    return level;
  }

  protected StringBuilder tab(StringBuilder sb, int tabLevel) {
    for (int i = 0; i < tabLevel; i++) {
      sb.append("\t");
    }
    return sb;
  }
  
  protected String toMessage(Object message) {
    return "" + level + " " + name + " " + Thread.currentThread() + "\n\t" + message; 
  }
  
  protected String toMessage(Object message, Throwable t) {
    return toMessage(message) + toMessage(t, new StringBuilder(),1);
  }
  
  protected String toMessage(Throwable t) {
    return toMessage(t.getMessage()) + 
        toMessage(t,new StringBuilder(),1);
  }
  
  protected String toMessage(Throwable t, StringBuilder sb, int tabLevel) {
    tab(sb, tabLevel).append(t.getMessage());
    StackTraceElement[] ste = t.getStackTrace();
    for (int i = 0; i < ste.length; i++) {
      tab(sb, tabLevel).append(ste[i]);
    } 
    if (t.getCause() != null) {
      return toMessage(t.getCause(), sb, tabLevel+1);
    }
    return sb.toString();
  }
  

}
