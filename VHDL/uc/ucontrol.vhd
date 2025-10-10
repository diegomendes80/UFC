library ieee;
use ieee.std_logic_1164.all;

entity ucontrol is
    port (
       entrada : in std_logic_vector(7 downto 0);
       saida : out std_logic_vector(7 downto 0)

    );
end ucontrol;


architecture logic of ucontrol is

begin
    with entrada select
        saida <= "00000000" when "00000000",
                "00000001" when "00000001",
                "11111111" when others;

                 
end architecture;

