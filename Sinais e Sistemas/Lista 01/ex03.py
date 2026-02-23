import numpy as np
import matplotlib.pyplot as plt

n = np.arange(0, 24)
omegas = [0.2*np.pi, 0.9*np.pi, 1.1*np.pi, 1.9*np.pi]

plt.figure(figsize=(10, 8))
for i, w in enumerate(omegas, 1):
    x = np.exp(1j * w * n)
    plt.subplot(2, 2, i)
    plt.stem(n, np.real(x), basefmt=" ")
    plt.title(f"ω₀ = {w/np.pi:.1f}π rad — Re{{e^(jω₀n)}}")
    plt.xlabel("n")
    plt.ylabel("x[n]")
    plt.grid(True)

plt.tight_layout()
plt.show()
