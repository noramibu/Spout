package spout.server.paper.impl.packetmapping.block.automatic;

import spout.server.paper.impl.packetmapping.block.BlockMappingsComposeEventImpl;

/**
 * A {@link RequestProcessor} for {@link AutomaticBlockMappingsImpl} requests
 * that are fulfilled using full blocks but backed by a block rather than a block state.
 */
public class BlockTypeFullBlockRequestProcessor extends FilledArrayResultRequestProcessor<FromToBlockTypeRequestBuilderImpl, ArrayResultRequestProcessor.RequestBasedResult> {

    public BlockTypeFullBlockRequestProcessor(FromToBlockTypeRequestBuilderImpl request, BlockMappingsComposeEventImpl event) {
        super(request, event);
    }

    @Override
    protected FilledArrayResultRequestProcessor<FromToBlockTypeRequestBuilderImpl, RequestBasedResult>.FillPromise constructFillPromise(final FilledArrayResultRequestProcessor<FromToBlockTypeRequestBuilderImpl, RequestBasedResult>.FillPromise kickoff) {
        return kickoff
            .then(attemptToClaimStatesFillPromiseStateByState(FullBlockRequestProcessor.FULL_BLOCK_PROXY_STATES::get))
            .then(new BlockFallbackFillPromise(this.request.fallback));
    }

}
