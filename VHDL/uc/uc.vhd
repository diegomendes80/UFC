library ieee;
use ieee.std_logic_1164.all;

entity uc is
    port (
       entrada : in std_logic_vector(7 downto 0);
       saida : out std_logic_vector(7 downto 0);

    );
end uc;


architecture logic of uc is

    signal ula_entrada : std_logic_vector(7 downto 0);
    signal ula_saida : std_logic_vector(7 downto 0);
    signal reg_we : std_logic;
    signal reg_data : std_logic_vector(7 downto 0);
    signal reg_addr : std_logic_vector(1 downto 0);
    signal reg_q0 : std_logic_vector(7 downto 0);
    signal reg_q1 : std_logic_vector(7 downto 0);       
    signal reg_q2 : std_logic_vector(7 downto 0);
    signal reg_q3 : std_logic_vector(7 downto 0);

    ula_inst.entity work.ULA
    port map (
        entrada => ula_entrada;
        saida => ula_saida;
    );

    reg_inst.entity work.REG
    port map (
            clk => clk;
            rst => rst;
            we  => reg_we;
            data  => reg_data;
            addr => reg_addr;
            q0  => reg_q0;
            q1 => reg_q1;
            q2 => reg_q2;
            q3 => reg_q3;
    );

 

    process(clk)
    begin
    
        if rising_edge(clk) then
            saida <= (others => '0');
            reg_we <= '0';
            reg_data <= (others => '0');
            reg_addr <= (others => '0');
            ula_entrada <= (others => '0');
        end if;

        elsif rising_edge(clk) then
            case entrada is
                --MOV
                when "00000000" =>
                    saida <= "00000000";
                    reg_we <= '1';
                    reg_addr <= "00";
                    reg_data <= reg_q0;

        end if;
    end process;
                 
end architecture;