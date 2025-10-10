library iee;
use ieee.std_logic_1164.all;


entity full_adder is
port(
  a: in std_logic;
  b: in std_logic;
  cin: in std_logic;
  cout: out std_logic;
  s: out std_logic  
  );
  
end full_adder;

architecture full_adder_arch of full_adder is
begin
  process(a, b, cin) is
  begin
    s<= a xor cin xor b; 
    cout <= (cin and b) or (a and b) or (cin and a);
    
  end process;
end full_adder_arch;



entity alu is port(
    A, B : in std_logic_vector(7 downto 0);
    O : out std_logic_vector(7 downto 0);
    S : in std_logic_vector(2 downto 0);

);

end alu;

architecture alu_arch of alu is

begin
   
        case S is
            when "000" => O <= A and B; -- AND
            when "001" => O <= A or B;  -- OR
            when "010" => O <= A xor B; -- XOR
            when "011" => O <= not A;   -- NOT A
            when "100" => O <= A + B;   -- ADD
            when "101" => O <= A - B;   -- SUBTRACT
    
            when others => O <= '00000000'; -- DEFAULT
        end case;
    


end architecture;