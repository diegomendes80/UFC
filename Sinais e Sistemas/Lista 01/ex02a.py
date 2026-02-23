import numpy as np
import matplotlib.pyplot as plt

n = np.arange(0, 40)

cases = {
    "exponencial_real": {"a": 0.2, "C": 1.0, "label": "e^{0.2 n} (real crescente)"},
    "complexo_puro": {"a": 1j * np.pi/4, "C": 1.0, "label": "e^{j pi/4 n} (oscilatório)"},
    "amortecido": {"a": -0.1 + 1j * np.pi/4, "C": 1.0, "label": "e^{-0.1 n} e^{j pi/4 n} (amortecido)"}
}

plt.figure(figsize=(10, 8))
for i, (k, params) in enumerate(cases.items(), 1):
    a = params["a"]
    C = params["C"]
    x = C * np.exp(a * n)
    plt.subplot(3, 2, 2*i-1)
    # Parte real (útil para sinais complexos ver o comportamento oscilatório)
    plt.stem(n, np.real(x), basefmt=" ", use_line_collection=True)
    plt.title(f"{params['label']} — parte real")
    plt.xlabel("n")
    plt.grid(True)

    plt.subplot(3, 2, 2*i)
    plt.stem(n, np.abs(x), basefmt=" ", use_line_collection=True)
    plt.title(f"{params['label']} — magnitude |x[n]| (C={C}, a={a})")
    plt.xlabel("n")
    plt.grid(True)
plt.tight_layout()
plt.show()
