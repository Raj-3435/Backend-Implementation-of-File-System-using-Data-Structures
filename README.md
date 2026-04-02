# Backend Implementation of File System

## 📌 Overview

This project is a modular file system engine that supports hierarchical data storage and intelligent query processing.

It combines multiple data structures and algorithms to efficiently handle different types of queries.

---

## 🧠 Key Features

* 📁 File system simulation (mkdir, ls, cd, delete)
* 🌳 Tree-based hierarchical structure
* 🔍 Fast prefix search using Trie
* ⚡ Decision layer to choose optimal algorithm
* 🔄 DFS traversal for full search

---

## ⚙️ Tech Concepts Used

* N-ary Trees
* Trie (Prefix Tree)
* DFS Traversal
* HashMap for O(1) lookup
* Object-Oriented Design

---

## 🧩 Architecture

User Query → QueryEngine → (Trie / DFS / Exact Search) → FileSystem → Result

---

## 🚀 Example

search("doc") → Uses Trie → Returns matching paths

search("*") → Uses DFS → Returns all files

---

## 🎯 Learning Outcome

This project demonstrates:

* When to use different data structures
* How to design modular systems
* How to build decision-based logic

---

## 📌 Future Scope

* Graph Engine for network queries
* Query caching (DP optimization)
* Range query support (Segment Tree)

---

## 👨‍💻 Author

Aditya Raj
