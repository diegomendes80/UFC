import numpy as np
import matplotlib.pyplot as plt

f0 = 120.0
Ps = [3, 5, 10, 60]

plt.figure(figsize=(10, 8))
for i, P in enumerate(Ps, 1):
    k = np.arange(P)
    x = np.sin(2 * np.pi * k / P)
    t = k / P * (1.0 / f0)  # tempo em segundos
    plt.subplot(2, 2, i)
    plt.stem(t, x, basefmt=" ")  # ← removido use_line_collection
    plt.plot(
        np.linspace(0, 1 / f0, 200),
        np.sin(2 * np.pi * f0 * np.linspace(0, 1 / f0, 200)),
        alpha=0.4,
        label="Sinal contínuo"
    )
    plt.title(f"P = {P} amostras por período")
    plt.xlabel("Tempo (s)")
    plt.ylabel("Amplitude")
    plt.grid(True)
plt.tight_layout()
plt.show()
