library iee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity reg is
  
    port (
        clk     : in  std_logic;
        rst     : in  std_logic;
        we   : in  std_logic;
        data       : inout  std_logic_vector(7 downto 0);
        addr       : in std_logic_vector(1 downto 0);
        q0       : inout std_logic_vector(7 downto 0);
        q1       : inout std_logic_vector(7 downto 0);
        q2       : inout std_logic_vector(7 downto 0);
        q3       : inout std_logic_vector(7 downto 0);
    );
end entity reg;


architecture arch_reg of reg is

    type regs_reg is array(0 to 3) of std_logic_vector(7 downto 0);
    signal regs : regs_reg := (others => (others => '0'));
    
    process(clk)
    begin
        if rising_edge(clk) then
            if rst = '1' then
                regs <= (others => (others => '0'));
            elsif we = '1' then
                regs(addr) <= data;
            end if;

            end if;

         if we = '0' then
        data <= regs(addr);
        end if;
    
        
        else (others => 'Z');

        q0 <= regs(0);
        q1 <= regs(1);
        q2 <= regs(10);
        q3 <= regs(11); 
    end process;

   


end architecture;