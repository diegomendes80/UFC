import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Carrega o arquivo com as amostras
df = pd.read_csv("samples.csv")
t = df['t_n'].values
x = df['x_n'].values

# Função de média móvel
def moving_average(x, M):
    kernel = np.ones(2*M+1) / (2*M+1)
    return np.convolve(x, kernel, mode='same')

# Testa vários valores de M e calcula a variância do residual
Ms = [1, 2, 3, 5, 10, 20, 50, 100]
res_vars = []
for M in Ms:
    y = moving_average(x, M)
    res_vars.append(np.var(x - y))

# Gráfico 1: variância do residual em função de M
plt.figure(figsize=(8,4))
plt.plot(Ms, res_vars, '-o')
plt.xlabel('M (metade da janela)')
plt.ylabel('Variância do residual')
plt.title('Variância do residual em função de M')
plt.grid(True)
plt.show()

# Escolha do M ótimo
M_opt = 10
y_opt = moving_average(x, M_opt)

# Gráfico 2: sinal original e filtrado
plt.figure(figsize=(10,6))
plt.plot(t, x, label='x[n] (ruidoso)', alpha=0.5)
plt.plot(t, y_opt, label=f'y[n] (filtrado, M={M_opt})', linewidth=2)
plt.xlabel('Tempo (s)')
plt.ylabel('Amplitude')
plt.title('Sinal original e sinal filtrado por média móvel')
plt.legend()
plt.grid(True)
plt.show()
