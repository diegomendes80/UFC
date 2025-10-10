import numpy as np # biblioteca pra fazer contas tipo sin e tanh, bem importante
import matplotlib.pyplot as plt # biblioteca pra plotar os graficos bonitinhos


# essa é a faixa do tempo, pensei em 1000 pontos pra ficar suave, vai de -0.01 a 0.01s
t = np.linspace(-0.01, 0.01, 1000)  

# Entradas de acordo com o que pediram, dois sinais diferentes
v1 = 10 * np.sin(1000 * t)  # Caso 1, amplitude alta, sinal vai saturar facil
v2 = 1 * np.sin(1000 * t)   # Caso 2, amplitude baixa, small-signal, quase linear

# Saídas calculadas direto usando a função hiperbólica
# basicamente isso simula o amplificador não-linear
vout1 = np.tanh(v1)
vout2 = np.tanh(v2)

# iniciar a figura com tamanho decente
plt.figure(figsize=(12,8))

# grafico do input
plt.subplot(2,2,1)
plt.plot(t, v1, label="input")
plt.title("Entrada (sinal de entrada)")
plt.xlabel("tempo [s]")
plt.ylabel("tensão [V]")
plt.grid(True)

# Característica de transferência do amplificador
# aqui só pra ver como a função tanh se comporta no range de -10 a 10
vin_range = np.linspace(-10, 10, 500) #faixa de tensao de entrada
vout_transfer = np.tanh(vin_range) # calcula a saída, basicamente curva de saturação
plt.subplot(2,2,2)
plt.plot(vin_range, vout_transfer)
plt.title("Característica de transferência do amplificador")
plt.xlabel("tensão entrada [V]")
plt.ylabel("tensão saída [V]")
plt.grid(True)
plt.ylim(-1, 1) # limita o eixo y pra ficar mais visivel a saturação

# Saída caso 1
# nesse caso a entrada é grande, então o sinal de saída vai saturar e ficar achatado
plt.subplot(2,2,3)
plt.plot(t, vout1, label="caso 1", color="b")
plt.title("Saída - Caso 1 (amplitude alta)")
plt.xlabel("tempo [s]")
plt.ylabel("tensão saída [V]")
plt.grid(True)
plt.ylim(-1, 1) # força limite da saida pra mostrar saturação

# Saída caso 2
# aqui a entrada é pequena, então o sinal quase nao é afetado, praticamente linear
plt.subplot(2,2,4)
plt.plot(t, vout2, label="caso 2", color="g")
plt.title("Saída - Caso 2 (small-signal)")
plt.xlabel("tempo [s]")
plt.ylabel("tensão saída [V]")
plt.grid(True)
plt.ylim(-0.8, 0.8) # menor limite pq a amplitude é pequena, pra ficar mais parecido com o slide

plt.tight_layout()
plt.show()
