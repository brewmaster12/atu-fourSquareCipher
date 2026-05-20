# ATU Four Square Cipher

> Object Oriented Software Development — H.Dip. in Science (Software Development)  
> ATU, Galway City Campus | **Grade: 75%**

---

## Overview

A Java console application that encrypts and decrypts text files using the **Four Square Cipher** — a polygraphic substitution cipher invented by French cryptographer Felix Delastelle (1840–1902).

The cipher uses four 5×5 matrices arranged in a square to encrypt pairs of characters:

| Quadrant | Type | Contents |
|---|---|---|
| Upper-left & Lower-right | Plaintext squares | Standard alphabet |
| Upper-right & Lower-left | Ciphertext squares | Mixed random alphabetic sequence |

Each matrix holds 25 letters (`j` is merged with `i`). The same keyword is used for both encryption and decryption — making it a **symmetric cipher**.

---

## Running the Application

```bash
cd src
javac ie/atu/sw/Runner.java
java ie.atu.sw.Runner
```

---

## Features

- **File encryption & decryption** using the Four Square Cipher
- **Input validation** throughout:
  - Input and output files must end in `.txt`
  - Operation must be either `E` (encrypt) or `D` (decrypt)
- **Flexible key handling:**
  - Leave blank to use a default key
  - Special characters stripped automatically
  - Duplicate letters removed automatically
  - Any key length accepted
  - Deterministic — the same key always produces the same result
- **2D array implementation** — no Java Collections Framework

---

## How the Key Works

The encryption key generates a unique letter sequence to populate the two ciphertext squares. It can be:
- Randomly generated
- A single keyword (duplicates dropped)
- Two different keywords (duplicates dropped)

Any remaining positions (if key length < 25) are filled with the remaining alphabet in order.

---

## Design

- Package: `ie.atu.sw`
- Object-oriented design with good programming practices
- Parses and processes text files line-by-line

> ⚠️ **Note:** No generative AI was used in this assignment.
