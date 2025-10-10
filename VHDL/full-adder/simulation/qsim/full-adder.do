onerror {exit -code 1}
vlib work
vcom -work work full-adder.vho
vcom -work work Waveform1.vwf.vht
vsim -novopt -c -t 1ps -sdfmax full_adder_vhd_vec_tst/i1=full-adder_vhd.sdo -L cyclonev -L altera -L altera_mf -L 220model -L sgate -L altera_lnsim work.full_adder_vhd_vec_tst
vcd file -direction full-adder.msim.vcd
vcd add -internal full_adder_vhd_vec_tst/*
vcd add -internal full_adder_vhd_vec_tst/i1/*
proc simTimestamp {} {
    echo "Simulation time: $::now ps"
    if { [string equal running [runStatus]] } {
        after 2500 simTimestamp
    }
}
after 2500 simTimestamp
run -all
quit -f
