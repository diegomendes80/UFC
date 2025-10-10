
library IEEE;
use IEEE.std_logic_1164.all;

entity full-adder is
port(
  a: in std_logic;
  b: in std_logic;
  cin: in std_logic;
  cout: out std_logic;
  s: out std_logic  
  );
  
end full-adder;

architecture arch of full-adder is
begin
  process(a, b, cin) is
  begin
    s<= a xor (cin xor b); 
    cout <= (cin and b) or (a and b) or (cin and a);
    
  end process;
end arch;
