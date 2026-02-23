# Define uma semente para o gerador de números aleatórios,
# garantindo que os resultados sejam reproduzíveis
set.seed(0)

# Define a média (mu) e o desvio-padrão (sigma)
# da distribuição normal da temperatura da CPU
mu <- 62
sigma <- 3.5

# Gera 500 valores aleatórios com distribuição uniforme no intervalo (0,1)
# Esses valores serão usados na transformação de Box-Muller
U1 <- runif(500)
U2 <- runif(500)

# Aplica a transformação de Box-Muller para gerar variáveis
# com distribuição normal padrão (média 0 e desvio 1)
Z1 <- sqrt(-2 * log(U1)) * cos(2 * pi * U2)
Z2 <- sqrt(-2 * log(U1)) * sin(2 * pi * U2)

# Junta os dois vetores Z1 e Z2, obtendo 1000 valores normais padrão
Z <- c(Z1, Z2)

# Realiza a transformação linear para obter a temperatura da CPU,
# ajustando os valores para a média e o desvio-padrão do problema
T_box <- mu + sigma * Z

# Gera 1000 valores de temperatura usando o gerador normal embutido no R,
# apenas para fins de comparação com o método de Box-Muller
T_builtin <- rnorm(1000, mean = mu, sd = sigma)

# Calcula a média das temperaturas simuladas pelo método de Box-Muller
mean(T_box)

# Calcula o desvio-padrão das temperaturas simuladas pelo método de Box-Muller
sd(T_box)

# Obtém o menor valor de temperatura simulado pelo método de Box-Muller
min(T_box)

# Obtém o maior valor de temperatura simulado pelo método de Box-Muller
max(T_box)

# Calcula a média das temperaturas simuladas pelo gerador normal do R
mean(T_builtin)

# Calcula o desvio-padrão das temperaturas simuladas pelo gerador normal do R
sd(T_builtin)

# Obtém o menor valor de temperatura simulado pelo gerador normal do R
min(T_builtin)

# Obtém o maior valor de temperatura simulado pelo gerador normal do R
max(T_builtin)

# Calcula a probabilidade empírica de a temperatura ser maior que 68 °C
# contando a proporção de valores acima desse limite
mean(T_box > 68)

# Calcula a probabilidade teórica de T > 68 usando a distribuição normal
1 - pnorm(68, mean = mu, sd = sigma)

# Calcula a probabilidade teórica de a temperatura ultrapassar 75 °C,
# que representa um evento raro dentro do modelo adotado
1 - pnorm(75, mean = mu, sd = sigma)

# Constrói um histograma das temperaturas simuladas pelo método de Box-Muller,
# normalizando as frequências para representar densidade de probabilidade
hist(T_box, probability = TRUE, col = "lightgray",
     main = "Temperaturas simuladas (Box-Muller)",
     xlab = "Temperatura (°C)")

# Adiciona ao histograma a curva da densidade da normal teórica
# com a mesma média e desvio-padrão definidos no problema
curve(dnorm(x, mean = mu, sd = sigma), add = TRUE, lwd = 2)
