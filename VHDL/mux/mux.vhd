library ieee;
use ieee.std_logic_1164.all;

entity mux is
    port (
        sel : in std_logic_vector(1 downto 0);
        A : in std_logic_vector(3 downto 0);
        X : out std_logic
    );
end mux;


architecture rtl of mux is
    begin
        with sel select
            X <= A(0) when "00",
                 A(1) when "01",
                 A(2) when "10",
                 A(3) when others;

end rtl;

