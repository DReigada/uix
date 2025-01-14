(ns uix.dom.alpha
  "Public API"
  (:require [react-dom :as rdom]
            [uix.compiler.alpha :as compiler]))

;; react-dom top-level API

(defn render
  "Renders element into DOM node. The first argument is Hiccup or React element."
  [element node]
  (rdom/render element node))

(defn create-root [node]
  (rdom/unstable_createRoot node))

(defn render-root [element root]
  (.render root element))

(defn hydrate
  "Hydrates server rendered document at `node` with `element`."
  [element node]
  (rdom/hydrate element node))

(defn flush-sync! [cb]
  (rdom/flushSync cb))

(defn flush-controlled! [cb]
  (rdom/unstable_flushControlled cb))

(defn unmount-at-node
  "Unmounts React component rendered into DOM node"
  [node]
  (rdom/unmountComponentAtNode node))

(defn find-dom-node
  "Returns top-level DOM node associated with component"
  [component]
  (rdom/findDOMNode component))

(defn create-portal
  "Renders Hiccup element into DOM node"
  [child node]
  (rdom/createPortal child node))

;; react-dom/server top-level API

(defn render-to-string [element]
  "Renders to HTML string to be used with React"
  (.renderToString js/ReactDOMServer element))

(defn render-to-static-markup [element]
  "Renders to HTML string"
  (.renderToStaticMarkup js/ReactDOMServer element))

(defn render-to-stream [element]
  (.renderToNodeStream js/ReactDOMServer element))

(defn render-to-static-stream [element]
  (.renderToStaticNodeStream js/ReactDOMServer element))
