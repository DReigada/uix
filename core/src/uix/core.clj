(ns uix.core
  "Public API"
  (:require [uix.compiler.aot]
            [uix.source]))

(defn- no-args-component [sym body]
  `(defn ~sym []
     ~@body))

(defn- with-args-component [sym args body]
  `(defn ~sym [props#]
     (let [~args (cljs.core/array (glue-args props#))]
       ~@body)))

(defmacro defui
  "Compiles UIx component into React component at compile-time."
  [sym args & body]
  (uix.source/register-symbol! sym)
  `(do
     ~(if (empty? args)
        (no-args-component sym body)
        (with-args-component sym args body))
     (with-name ~sym)))

(defmacro source
  "Returns source string of UIx component"
  [sym]
  (uix.source/source sym))