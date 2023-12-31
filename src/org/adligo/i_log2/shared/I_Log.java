package org.adligo.i_log2.shared;

/**
 * This is the logger interface, for writing log messages.
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
public interface I_Log {

  /**
   * this is for constant logs (static final Log) that need to be turned
   * off from the LogDispatcher (or other impl code) so that a StackOverflow can
   * be obvoided
   * 
   * @return
   */
  boolean isEnabled();


  // ----------------------------------------------------- Logging Properties

  /**
   * <p>
   * Is debug logging currently enabled?
   * </p>
   *
   * <p>
   * Call this method to prevent having to perform expensive operations (for
   * example, <code>String</code> concatenation) when the log level is more than
   * debug.
   * </p>
   *
   * @return true if debug is enabled in the underlying logger.
   */
  boolean isDebugEnabled();

  /**
   * <p>
   * Is error logging currently enabled?
   * </p>
   *
   * <p>
   * Call this method to prevent having to perform expensive operations (for
   * example, <code>String</code> concatenation) when the log level is more than
   * error.
   * </p>
   *
   * @return true if error is enabled in the underlying logger.
   */
  boolean isErrorEnabled();

  /**
   * <p>
   * Is fatal logging currently enabled?
   * </p>
   *
   * <p>
   * Call this method to prevent having to perform expensive operations (for
   * example, <code>String</code> concatenation) when the log level is more than
   * fatal.
   * </p>
   *
   * @return true if fatal is enabled in the underlying logger.
   */
  boolean isFatalEnabled();

  /**
   * <p>
   * Is info logging currently enabled?
   * </p>
   *
   * <p>
   * Call this method to prevent having to perform expensive operations (for
   * example, <code>String</code> concatenation) when the log level is more than
   * info.
   * </p>
   *
   * @return true if info is enabled in the underlying logger.
   */
  boolean isInfoEnabled();

  /**
   * <p>
   * Is trace logging currently enabled?
   * </p>
   *
   * <p>
   * Call this method to prevent having to perform expensive operations (for
   * example, <code>String</code> concatenation) when the log level is more than
   * trace.
   * </p>
   *
   * @return true if trace is enabled in the underlying logger.
   */
  boolean isTraceEnabled();

  /**
   * <p>
   * Is warn logging currently enabled?
   * </p>
   *
   * <p>
   * Call this method to prevent having to perform expensive operations (for
   * example, <code>String</code> concatenation) when the log level is more than
   * warn.
   * </p>
   *
   * @return true if warn is enabled in the underlying logger.
   */
  boolean isWarnEnabled();

  // -------------------------------------------------------- Logging Methods

  /**
   * <p>
   * Log a message with trace log level.
   * </p>
   *
   * @param message log this message
   */
  void trace(Object message);

  /**
   * <p>
   * Log an error with trace log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void trace(Object message, Throwable t);

  /**
   * <p>
   * Log an error with trace log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void trace(Throwable t);

  /**
   * <p>
   * Log a message with debug log level.
   * </p>
   *
   * @param message log this message
   */
  void debug(Object message);

  /**
   * <p>
   * Log an error with debug log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void debug(Object message, Throwable t);

  /**
   * <p>
   * Log an error with debug log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void debug(Throwable t);
  
  /**
   * <p>
   * Log a message with info log level.
   * </p>
   *
   * @param message log this message
   */
  void info(Object message);

  /**
   * <p>
   * Log an error with info log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void info(Object message, Throwable t);

  /**
   * <p>
   * Log an error with info log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void info(Throwable t);

  /**
   * <p>
   * Log a message with warn log level.
   * </p>
   *
   * @param message log this message
   */
  void warn(Object message);

  /**
   * <p>
   * Log an error with warn log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void warn(Object message, Throwable t);

  /**
   * <p>
   * Log an error with warn log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void warn(Throwable t);
  
  /**
   * <p>
   * Log a message with error log level.
   * </p>
   *
   * @param message log this message
   */
  void error(Object message);

  /**
   * <p>
   * Log an error with error log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void error(Object message, Throwable t);

  /**
   * <p>
   * Log an error with error log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void error(Throwable t);
  
  /**
   * <p>
   * Log a message with fatal log level.
   * </p>
   *
   * @param message log this message
   */
  void fatal(Object message);

  /**
   * <p>
   * Log an error with fatal log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void fatal(Object message, Throwable t);

  /**
   * <p>
   * Log an error with fatal log level.
   * </p>
   *
   * @param message log this message
   * @param t       log this cause
   */
  void fatal(Throwable t);
  
  /**
   * returns the name of the log or log Class
   * is used to determine a unique logger
   * equals and hashCode
   * 
   * @return
   */
  public String getLogName();
  
  /**
   * returns one of the shorts from I_LogDelegate that pertains to if this log is
   * Debug, Warn exc
   * 
   * @return
   */
  LogLevel getLevel();
}
