package com.ssw.prod.mincer.utils.log;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 *
 * @author m.genova
 * @since 0.1
 */
public class LogUtil {
    
    public static final Marker UTIL_MARKER = MarkerFactory.getMarker("UTILITY");
    public static final Marker DB_MARKER = MarkerFactory.getMarker("DATABASE");
    public static final Marker EXECUTOR_MARKER = MarkerFactory.getMarker("EXECUTOR");
    public static final Marker CONFIGURATOR_MARKER = MarkerFactory.getMarker("CONFIGURATOR");
    public static final Marker MODEL_MARKER = MarkerFactory.getMarker("MODEL");
    public static final Marker STRUCTURE_MARKER = MarkerFactory.getMarker("STRUCTURE");
    public static final Marker SOURCES_MARKER = MarkerFactory.getMarker("SOURCES");
    public static final Marker PRODUCERS_MARKER = MarkerFactory.getMarker("EXECUTOR");
    
}
